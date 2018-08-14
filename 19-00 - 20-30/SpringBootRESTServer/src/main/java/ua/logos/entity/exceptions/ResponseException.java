package ua.logos.entity.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class ResponseException {

    private String description;
    private Date date;
    private String uri;
}
