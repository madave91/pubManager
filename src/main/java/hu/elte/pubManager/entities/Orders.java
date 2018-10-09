/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author madave91
 */


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Orders implements Serializable {
    @ManyToOne
    @JoinColumn
    private Bar bar;
    
    @Column(unique = true)
    @NotNull
    private String propertyX;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    @Temporal(TemporalType.TIME)
    private Date time;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at;

    @Column
    @UpdateTimestamp
    private LocalDateTime updated_at;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
}

