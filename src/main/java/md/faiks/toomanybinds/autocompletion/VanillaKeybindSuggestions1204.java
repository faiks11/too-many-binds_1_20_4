package md.faiks.toomanybinds.autocompletion;

import com.github.reviversmc.toomanybinds.autocompletion.BindSuggestion;
import com.github.reviversmc.toomanybinds.autocompletion.VanillaKeybindSuggestions;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;

public class VanillaKeybindSuggestions1204 extends VanillaKeybindSuggestions {
	@Override
	protected KeyBinding[] allKeys(GameOptions options) {
		return options.allKeys;
	}

	@Override
	protected BindSuggestion newBindSuggestion(KeyBinding bind) {
		return new BindSuggestion1204(bind);
	}
}
