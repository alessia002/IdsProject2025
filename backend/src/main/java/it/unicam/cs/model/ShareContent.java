package it.unicam.cs.model;

import it.unicam.cs.enums.SocialPlatform;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "share_content")
@NoArgsConstructor
@AllArgsConstructor
public class ShareContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 2048)
    private String text;
    @Enumerated(EnumType.STRING)
    private SocialPlatform platform;
    private String externalPostId;
}
