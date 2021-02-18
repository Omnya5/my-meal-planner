package pl.strzygowska.mymealplanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.strzygowska.mymealplanner.model.Note;
import pl.strzygowska.mymealplanner.model.NoteDao;

import javax.transaction.Transactional;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class NoteTest {

    @Autowired
    private NoteDao noteDao;

    @Test
    public void testSave() {
        Note note = new Note("This is a test saving note.");

        noteDao.save(note);

        assertNotNull("Non-null ID", note.getId());
        assertNotNull("Non-null Date", note.getAdded());

        Note retrieved = noteDao.findById(note.getId()).orElse(new Note());
        assertEquals("Matching Note", note, retrieved);
    }

    @Test
    public void testFindLatest(){
        Calendar calendar = Calendar.getInstance();
        Note lastNote = null;

        for(int i=0; i<10; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            Note note = new Note("Status update " + i, calendar.getTime());
            noteDao.save(note);
            lastNote = note;
        }

        Note retrieved = noteDao.findFirstByOrderByAddedDesc();
        assertEquals("Latest note update", lastNote, retrieved);
    }
}


