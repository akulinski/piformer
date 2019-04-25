package com.akulinski.piformer.core.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "command_history")
@Data
public class CommandHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column
    private String output;

    @OneToOne
    private User poster;

    @ManyToOne
    @JoinColumn
    private Command command;

}
