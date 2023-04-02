package com.conferenceSystem.service;

import com.conferenceSystem.model.Conference;
import com.conferenceSystem.repository.ConferenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceService {
    private ConferenceRepository conferenceRepository;

    private ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public List<Conference> listAll() {
        return conferenceRepository.findAll();
    }
    public Conference save(Conference conference){
        return conferenceRepository.save(conference);
    }
    public Conference get(Long id){
        return conferenceRepository.findById(id).get();
    }
    public void delete(Long id){
        conferenceRepository.deleteById(id);
    }


}
