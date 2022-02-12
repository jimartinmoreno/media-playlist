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
    @JsonProperty("created_on")
    private Date createdOn;

    //@ElementCollection(targetClass = java.util.ArrayList.class)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="playlist_id")
    private Set<Song> songs  = new HashSet<>();
}
