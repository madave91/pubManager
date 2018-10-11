/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.repositories;

/**
 *
 * @author madave91
 */
import hu.elte.pubManager.model.Issue;
import hu.elte.pubManager.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends CrudRepository<Issue, Integer> {
    public Iterable<Issue> findAllByUser(User user);
}
