package hibernate.example;

import hibernate.example.entities.Singer;

import java.util.List;

public interface SingerDao {
	List<Singer> findAll();

	List<Singer> findAllWithAlbum();

	Singer findById(Long id);

	Singer save(Singer singer);

	void delete(Singer singer);
}
