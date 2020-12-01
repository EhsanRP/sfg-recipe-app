package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void saveImageFile(Long id, MultipartFile file) {
        log.debug("Received a File");

        try {
            Recipe recipe = recipeRepository.findById(id).get();
            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte each: file.getBytes()){
                byteObjects[i++] = each;
            }

            recipe.setImage(byteObjects);

            recipeRepository.save(recipe);
        }catch (IOException ioException){
            //TODO HANDLE BETTER
            log.error("Error Occurred",ioException);
            ioException.printStackTrace();
        }
    }
}
