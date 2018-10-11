/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.controller;

/**
 *
 * @author madave91
 */
import hu.elte.pubManager.model.Issue;
import hu.elte.pubManager.model.Label;
import hu.elte.pubManager.model.Message;
import hu.elte.pubManager.model.User;
import hu.elte.pubManager.repositories.IssueRepository;
import hu.elte.pubManager.repositories.LabelRepository;
import hu.elte.pubManager.repositories.MessageRepository;
import hu.elte.pubManager.security.AuthenticatedUser;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/issues")
public class IssueController {
    
    @Autowired
    private IssueRepository issueRepository;
    
    @Autowired
    private MessageRepository messageRepository;
    
    @Autowired
    private LabelRepository labelRepository;
    
    @Autowired
    private AuthenticatedUser authenticatedUser;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Issue>> getAll() {
        User user = authenticatedUser.getUser();
        User.Role role = user.getRole();
        if (role.equals(User.Role.ROLE_ADMIN)) {
            return ResponseEntity.ok(issueRepository.findAll());
        } else {
            return ResponseEntity.ok(issueRepository.findAllByUser(user));
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Issue> get(@PathVariable Integer id) {
        Optional<Issue> issue = issueRepository.findById(id);
        if (issue.isPresent()) {
            return ResponseEntity.ok(issue.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("")
    public ResponseEntity<Issue> post(@RequestBody Issue issue) {
        User user = authenticatedUser.getUser();
        issue.setUser(user);
        Issue savedIssue = issueRepository.save(issue);
        return ResponseEntity.ok(savedIssue);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Issue> update
            (@PathVariable Integer id,
             @RequestBody Issue issue) {
        Optional<Issue> oIssue = issueRepository.findById(id);
        if (oIssue.isPresent()) {
            issue.setId(id);
            return ResponseEntity.ok(issueRepository.save(issue));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
            
    @DeleteMapping("/{id}")
    public ResponseEntity<Issue> delete
            (@PathVariable Integer id) {
        Optional<Issue> oIssue = issueRepository.findById(id);
        if (oIssue.isPresent()) {
            issueRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
            
    @GetMapping("/{id}/messages")
    public ResponseEntity<Iterable<Message>> messages
            (@PathVariable Integer id) {
        Optional<Issue> issue = issueRepository.findById(id);
        if (issue.isPresent()) {
            return ResponseEntity.ok(issue.get().getMessages());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
            
    @PostMapping("/{id}/messages")
    public ResponseEntity<Message> insertMessage
            (@PathVariable Integer id,
             @RequestBody Message message) {
        Optional<Issue> oIssue = issueRepository.findById(id);
        if (oIssue.isPresent()) {
            Issue issue = oIssue.get();
            message.setIssue(issue);
            return ResponseEntity.ok(
                messageRepository.save(message));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
            
    @GetMapping("/{id}/labels")
    public ResponseEntity<Iterable<Label>> labels
        (@PathVariable Integer id) {
        Optional<Issue> oIssue = issueRepository.findById(id);
        if (oIssue.isPresent()) {
            return ResponseEntity.ok(oIssue.get().getLabels());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
        
    @PostMapping("/{id}/labels")
    public ResponseEntity<Label> insertLabel
        (@PathVariable Integer id, 
         @RequestBody Label label) {
        Optional<Issue> oIssue = issueRepository.findById(id);
        if (oIssue.isPresent()) {
            Issue issue = oIssue.get();
            Label newLabel = labelRepository.save(label);
            issue.getLabels().add(newLabel);
            issueRepository.save(issue);
            return ResponseEntity.ok(newLabel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
        
    @PutMapping("/{id}/labels")
    public ResponseEntity<Iterable<Label>> modifyLabels
        (@PathVariable Integer id,
         @RequestBody List<Label> labels) {
        Optional<Issue> oIssue = issueRepository.findById(id);
        if (oIssue.isPresent()) {
            Issue issue = oIssue.get();
            
            for (Label label: labels) {
                if (label.getId() == null) {
                    labelRepository.save(label);
                }
            }
            
            issue.setLabels(labels);
            issueRepository.save(issue);
            return ResponseEntity.ok(labels);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
