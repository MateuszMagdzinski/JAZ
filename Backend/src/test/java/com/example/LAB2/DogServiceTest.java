//package com.example.LAB2;
//
//import com.example.LAB2.Backend.Dog;
//import com.example.LAB2.Backend.Repo.DogsRepository;
//import com.example.LAB2.Backend.exception.DogExist;
//import com.example.LAB2.Backend.exception.DogNotExist;
//import com.example.LAB2.Backend.service.DogService;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//class DogServiceTest {
//
//    @Mock
//    private DogsRepository repository;
//
//    @InjectMocks
//    private DogService dogService;
//
//    @Test
//    void deleteDogByName_WhenDogExists_ShouldDeleteDog() {
//        // Arrange
//        Dog existingDog = new Dog("bogdan", 6);
//        when(repository.findByName("bogdan")).thenReturn(Optional.of(existingDog));
//
//        // Act
//        dogService.deleteDogByName("bogdan");
//
//        // Assert
//        Mockito.verify(repository).delete(existingDog);
//    }
//
//    @Test
//    void deleteDogByName_WhenDogDoesNotExist_ShouldThrowException() {
//        // Arrange
//        when(repository.findByName(anyString())).thenReturn(Optional.empty());
//
//        // Act & Assert
//        assertThrows(DogNotExist.class, () -> dogService.deleteDogByName("NonExistentDog"));
//    }
//}
