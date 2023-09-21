package tudor.practice.spotify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tudor.practice.spotify.model.ArtistModel;
import tudor.practice.spotify.service.ArtistService;

@RestController
@RequestMapping(path = "api/spotify/artist")
public class ArtistController {
    
    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    
    @GetMapping(path = "")
    public List<ArtistModel> getAllArtists()
    {
        return artistService.getAllArtists();
    }

    @GetMapping(path = "/{id}")
    public ArtistModel getArtistById(@PathVariable Long id)
    {
        return artistService.getArtistById(id);
    }


    @PostMapping
    public void addArtist(@RequestBody ArtistModel artist)
    {
        artistService.addArtist(artist);
    }

    
}
