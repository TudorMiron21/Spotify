package tudor.practice.spotify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tudor.practice.spotify.model.ArtistModel;
import tudor.practice.spotify.repository.ArtistRepository;


@Service
public class ArtistService {
    
    private final ArtistRepository artistRepository;


    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    
    public List<ArtistModel> getAllArtists(){
        return artistRepository.findAll();
    }  

    public ArtistModel getArtistById(Long id)
    {
        return artistRepository.findById(id).orElse(null);
    }


    public void addArtist(ArtistModel artist)
    {
        if(artistRepository.findByEmail(artist.getEmail()).isPresent())
        {
            throw new IllegalStateException("Email allready used");
        }
        else
        {
            artistRepository.save(artist);
        }
    }


}
