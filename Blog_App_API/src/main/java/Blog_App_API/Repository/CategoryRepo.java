package Blog_App_API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Blog_App_API.Entity.category;

public interface CategoryRepo extends JpaRepository<category, Integer>{

}
