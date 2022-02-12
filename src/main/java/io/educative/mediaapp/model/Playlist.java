package io.educative.mediaapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.*;

@Data
@Entity
@Table(name="playlist")
public class Playlist {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private BigInteger id;

    private String name;

    @Column(name = "created_on")
    @JsonProperty("created_on") // Property name refers to name used externally, as the field name in JSON objects.
    private Date createdOn;

    //@ElementCollection(targetClass = java.util.HashSet.class) // specifies a collection of instances of a basic type or embeddable/nested class
    @OneToMany(cascade = CascadeType.ALL) // specifies a many-valued association with one-to-many multiplicity
    @JoinColumn(name="playlist_id") // specifies a column for joining an entity association or element collection

    private Set<Song> songs  = new HashSet<>();
}
