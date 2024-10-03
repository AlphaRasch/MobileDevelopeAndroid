package ru.chekalinev.fortravelers.domain.usecases;

import ru.chekalinev.fortravelers.domain.repository.LandmarkRepository;

public class GetLandmarksUseCase {
    private LandmarkRepository landmarkRepository;
    public GetLandmarksUseCase(LandmarkRepository landmarkRepository){
        this.landmarkRepository = landmarkRepository;
    }
    public String execute(){
        return landmarkRepository.GetLandmarks();
    }
}
