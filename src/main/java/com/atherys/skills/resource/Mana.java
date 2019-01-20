package com.atherys.skills.resource;

import com.atherys.skills.api.resource.Resource;
import org.spongepowered.api.text.format.TextColors;

public class Mana extends AbstractResource {

    protected Mana(double starting) {
        super(
                TextColors.BLUE,
                "atherys:mana",
                "Mana",
                100.0d,
                starting,
                5.0d
        );
    }

    @Override
    public Resource copy() {
        return new Mana(getCurrent());
    }

}
