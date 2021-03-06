package com.atherys.skills.listener;

import com.atherys.skills.api.event.ResourceEvent;
import com.atherys.skills.facade.ResourceFacade;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.spongepowered.api.event.Listener;

@Singleton
public class ResourceListener {
    @Inject
    private ResourceFacade resourceFacade;

    @Listener
    public void onResourceRegen(ResourceEvent.Regen event) {
        resourceFacade.onResourceRegen(event);
    }
}
