package de.leuphana.webshop.webshopclient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

// -> Builder Pattern automatically implemented
// From Lombok -> Creates getters and setters
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDto {

    private UUID id;
    private String manufacturer;
    private String name;
    private Long price;



}
