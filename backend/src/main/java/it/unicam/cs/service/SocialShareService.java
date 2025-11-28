package it.unicam.cs.service;

import it.unicam.cs.dto.ShareContentDTO;
import it.unicam.cs.mapper.ShareContentMapper;
import it.unicam.cs.model.ShareContent;
import it.unicam.cs.platform.FacebookShareAdapter;
import it.unicam.cs.platform.SocialShareTarget;
import it.unicam.cs.repository.ShareContentRepository;
import org.springframework.stereotype.Service;

@Service
public class SocialShareService {
    private final ShareContentRepository repo;
    private final ShareContentMapper mapper;

    public SocialShareService(ShareContentRepository repo, ShareContentMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public ShareContentDTO share(ShareContentDTO dto) {
        ShareContent content = mapper.toEntity(dto);
        SocialShareTarget adapter;
        switch (content.getPlatform()) {
            case FACEBOOK -> adapter = new FacebookShareAdapter();
            case INSTAGRAM -> throw new IllegalArgumentException("Instagram not supported yet");
            default -> throw new IllegalArgumentException("Social platform not supported");
        };
        String externalId = adapter.share(content);
        content.setExternalPostId(externalId);
        return mapper.toDTO(repo.save(content));
    }
}
