package br.com.cinq.greet.model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.Serializable;

/**
 * Created by Gabriel on 16/11/2015.
 * Domain message.
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 4551949391645919045L;

    private Long id;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
