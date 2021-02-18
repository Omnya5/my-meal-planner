package pl.strzygowska.mymealplanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.strzygowska.mymealplanner.model.Note;
import pl.strzygowska.mymealplanner.model.NoteDao;

@Service
public class NoteService {

    private final static int PAGESIZE = 3;

    @Autowired
    private NoteDao noteDao;

    public void save(Note note) {
        noteDao.save(note);
    }

    public Note getLatest() {
        return noteDao.findFirstByOrderByAddedDesc();
    }

    public Page<Note> getPage(int pageNumber) {
        PageRequest request = PageRequest.of(pageNumber - 1, PAGESIZE, Sort.by("added").descending());
        return noteDao.findAll(request);
    }
}
