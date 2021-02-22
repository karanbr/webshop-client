package de.leuphana.webshop.webshopclient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNullFields;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.util.UUID;

// -> Builder Pattern automatically implemented
// From Lombok -> Creates getters and setters
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDto {

    private UUID id;
    private String name;
    private String manufacturer;
    private Long price;



}
