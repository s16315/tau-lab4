package gamesCatalog;
import java.time.LocalDateTime;

public abstract class Entity {
    private long id;
    private LocalDateTime creationDate;
    private LocalDateTime lastChangeDate;
    private LocalDateTime lastReadDate;

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(LocalDateTime lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public LocalDateTime getLastReadDate() {
        return lastReadDate;
    }

    public void setLastReadDate(LocalDateTime lastReadDate) {
        this.lastReadDate = lastReadDate;
    }

    public long getId() {
        return id;
    }
    void setId(long id) {
        this.id = id;
    }
}
