package edu.taipp.service;

import edu.taipp.model.User;
import edu.taipp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(Long id) {
    return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
  }

  public User createUser(User user) {
    // Kiểm tra email unique
    if (userRepository.findByEmail(user.getEmail()).isPresent()) {
      throw new RuntimeException("Email already exists: " + user.getEmail());
    }
    return userRepository.save(user);
  }

  public User updateUser(Long id, User user) {
    User existingUser = getUserById(id);
    existingUser.setUsername(user.getUsername());
    existingUser.setProviderId(user.getProviderId());
    // Không cho phép thay đổi email để giữ tính unique
    return userRepository.save(existingUser);
  }

  public void deleteUser(Long id) {
    User user = getUserById(id);
    userRepository.delete(user);
  }

  // Phương thức tìm theo email (tùy chọn)
  public User findByEmail(String email) {
    return userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
  }
}