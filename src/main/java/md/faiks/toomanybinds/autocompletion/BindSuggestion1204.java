package md.faiks.toomanybinds.autocompletion;

import com.github.reviversmc.toomanybinds.autocompletion.BindSuggestion;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.text.Text;

import java.util.function.Consumer;

public class BindSuggestion1204 extends BindSuggestion {

	public BindSuggestion1204(KeyBinding bind) {
		super(bind);
	}

	@Override
	protected Text newTranslatableText(String key) {
		return Text.translatable(key);
	}

	@Override
	protected void saveFullscreenState(GameOptions options, boolean fullscreen) {
		options.getFullscreen().setValue(fullscreen);
	}

	@Override
	protected KeyBinding fullscreenKey(GameOptions options) {
		return options.fullscreenKey;
	}

	@Override
	protected KeyBinding screenshotKey(GameOptions options) {
		return options.screenshotKey;
	}

	@Override
	protected void takeScreenshot(MinecraftClient mc, Consumer<Text> consumer) {
		ScreenshotRecorder.saveScreenshot(mc.runDirectory, mc.getFramebuffer(), consumer);
	}
}
