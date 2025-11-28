package it.unicam.cs.platform;

import it.unicam.cs.model.ShareContent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FacebookShareAdapter implements SocialShareTarget {
    @Override
    public String share(ShareContent content) {
        log.info("Simulation - Sharing on Facebook: {}", content.getTitle());
        return "FB_POST_" + System.currentTimeMillis();
    }
}
