package tudor.practice.spotify.model;

import java.util.HashSet;
import java.util.Set;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "artist")
@Table(name = "artist")
public class ArtistModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    // an artist has followers, but an user wcan only follow artists. They cannot
    // have followers
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REMOVE
    })
    @JoinTable(name = "Artist_User", joinColumns = @JoinColumn(name = "artist_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<UserModel> followersList = new HashSet<>();


    // the list of songs of an artist
    @OneToMany(mappedBy = "artist")
    private Set<SongModel> songs;

    public ArtistModel() {
    }

    // Constructor with parameters
    public ArtistModel(String name, String email) {
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

    public Set<UserModel> getFollowersList() {
        return followersList;
    }

    public void setFollowersList(Set<UserModel> followersList) {
        this.followersList = followersList;
    }

    public Set<SongModel> getSongs() {
        return songs;
    }

    public void setSongs(Set<SongModel> songs) {
        this.songs = songs;
    }

    // toString method
    @Override
    public String toString() {
        return "ArtistModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
