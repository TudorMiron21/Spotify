package tudor.practice.spotify.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "song")
@Entity(name = "song")
public class SongModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "no_seconds")
    private Integer noSeconds;

    @ManyToOne
    private ArtistModel artist;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REMOVE
    }, mappedBy = "likedSongs")
    @JsonIgnore
    private Set<UserModel> likingUsers = new HashSet<>();

    public SongModel() {
    }

    public SongModel(String name, Integer noSeconds, ArtistModel artist, Set<UserModel> likingUsers) {
        this.name = name;
        this.noSeconds = noSeconds;
        this.artist = artist;
        this.likingUsers = likingUsers;
    }

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

    public Integer getNoSeconds() {
        return noSeconds;
    }

    public void setNoSeconds(Integer noSeconds) {
        this.noSeconds = noSeconds;
    }

    public ArtistModel getArtist() {
        return artist;
    }

    public void setArtist(ArtistModel artist) {
        this.artist = artist;
    }

    public Set<UserModel> getLikingUsers() {
        return likingUsers;
    }

    public void setLikingUsers(Set<UserModel> likingUsers) {
        this.likingUsers = likingUsers;
    }

    @Override
    public String toString() {
        return "SongModel [id=" + id + ", name=" + name + ", noSeconds=" + noSeconds + ", artist=" + artist
                + ", likingUsers=" + likingUsers + "]";
    }

}
