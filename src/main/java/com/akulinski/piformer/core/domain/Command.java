package com.akulinski.piformer.core.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "command")
public class Command extends Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column
    private String description;

    @Column
    private String value;

    @OneToMany(mappedBy = "command", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CommandHistory> commandHistorySet;

    public Command() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Set<CommandHistory> getCommandHistorySet() {
        return commandHistorySet;
    }

    public void setCommandHistorySet(Set<CommandHistory> commandHistorySet) {
        this.commandHistorySet = commandHistorySet;
    }
}
