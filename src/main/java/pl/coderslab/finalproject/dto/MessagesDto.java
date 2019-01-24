package pl.coderslab.finalproject.dto;


import java.time.LocalDateTime;


public class MessagesDto {


    private Long id;

    private String message;

    private LocalDateTime createDateTime;



    public MessagesDto() {
    }

    public MessagesDto(String message, LocalDateTime createDateTime) {
        this.message = message;
        this.createDateTime = createDateTime;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

}
