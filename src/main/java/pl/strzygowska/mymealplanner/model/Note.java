package pl.strzygowska.mymealplanner.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 255, message = "{addNote.text.size}")
    @NotBlank(message = "{addNote.text.blank}")
    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    private Date added;

    @PrePersist
    protected void onCreate(){
        if(added == null) {
            added = new Date();
        }
    }

    public Note() {
    }

    public Note(@Size(min = 3, max = 255) @NotBlank String text) {
        this.text = text;
    }

    public Note(@Size(min = 3, max = 255) @NotBlank String text, Date added) {
        this.text = text;
        this.added = added;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id.equals(note.id) &&
                Objects.equals(text, note.text) &&
                Objects.equals(added, note.added);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, added);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", added=" + added +
                '}';
    }
}
