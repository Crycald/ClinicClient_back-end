package com.client.clientapi.domain.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoripsumDto {
    private String textLength;
    private String textType;
    private int paragraphs;
    private String content;
}
