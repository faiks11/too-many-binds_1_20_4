package md.faiks.toomanybinds;

import com.github.reviversmc.toomanybinds.TooManyBinds;
import md.faiks.toomanybinds.autocompletion.VanillaKeybindSuggestions1204;
import net.minecraft.client.MinecraftClient;

import com.github.reviversmc.toomanybinds.autocompletion.VanillaKeybindSuggestions;

public class TooManyBinds1204 extends TooManyBinds {
	@Override
	protected VanillaKeybindSuggestions newVanillaKeyBindSuggestions() {
		return new VanillaKeybindSuggestions1204();
	}

	@Override
	protected void openNewLauncherScreen(MinecraftClient client) {
		client.setScreen(new LauncherScreen1204());
	}
}
