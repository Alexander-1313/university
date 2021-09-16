package com.rybaq.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subject")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "subject", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Teacher teacher;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "subject_group",
    joinColumns = {@JoinColumn(name="subject_id")},
    inverseJoinColumns = {@JoinColumn(name = "group_id")})
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Set<Group> groups = new HashSet<>();

    public void addGroup(Group group){
        this.groups.add(group);
        group.getSubjects().add(this);
    }

    public void removeGroup(Group group){
        this.groups.remove(group);
        group.getSubjects().remove(this);
    }
}
