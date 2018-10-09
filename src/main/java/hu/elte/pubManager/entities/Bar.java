/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.OneToMany;

/**
 *
 * @author madave91
 */
public class Bar {
    @JsonIgnore
    @OneToMany(mappedBy = "bar")
    private List<Orders> orders;
}
