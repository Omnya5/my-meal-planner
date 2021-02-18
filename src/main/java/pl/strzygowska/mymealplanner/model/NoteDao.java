package pl.strzygowska.mymealplanner.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteDao extends JpaRepository <Note, Long> {
    Note findFirstByOrderByAddedDesc();
}
