package it.unicam.cs.platform;

import it.unicam.cs.model.ShareContent;

public interface SocialShareTarget {
    String share(ShareContent content);
}
