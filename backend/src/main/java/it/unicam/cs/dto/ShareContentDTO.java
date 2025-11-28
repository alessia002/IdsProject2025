package it.unicam.cs.dto;

import it.unicam.cs.enums.SocialPlatform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShareContentDTO {
    private Long id;
    private String title;
    private String text;
    private SocialPlatform platform;
    private String externalPostId;
}
