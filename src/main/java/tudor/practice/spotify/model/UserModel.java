package tudor.practice.spotify.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Table(name = "users")
@Entity(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REMOVE
    }, mappedBy = "followersList")
    @JsonIgnore
    private Set<ArtistModel> followingArtists = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REMOVE
    })
    @JoinTable(name = "User_Song", 
        joinColumns = { @JoinColumn(name = "user_id"),},
        inverseJoinColumns = { @JoinColumn(name = "song_id") }
    )
    private Set<SongModel> likedSongs = new HashSet<>();

    // Default constructor
    public UserModel() {
    }

    // Constructor with parameters
    public UserModel(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ArtistModel> getFollowingArtists() {
        return followingArtists;
    }

    public void setFollowingArtists(Set<ArtistModel> followingArtists) {
        this.followingArtists = followingArtists;
    }

    public Set<SongModel> getLikedSongs() {
        return likedSongs;
    }

    public void setLikedSongs(Set<SongModel> likedSongs) {
        this.likedSongs = likedSongs;
    }

    // toString method
    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
