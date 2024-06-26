package com.github.reviversmc.toomanybinds;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.apache.logging.log4j.LogManager;
import org.lwjgl.glfw.GLFW;

import org.apache.logging.log4j.Logger;
import com.github.reviversmc.toomanybinds.autocompletion.LauncherCompletion;
import com.github.reviversmc.toomanybinds.autocompletion.VanillaKeybindSuggestions;



public abstract class TooManyBinds implements ModInitializer {
	public static ModConfig config;
	public static KeyBinding launcherKey;
	public static KeyBinding favoriteKey;
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public void onInitialize() {
		LOGGER.info("TOO MANY BINDS WORK");
		LOGGER.info("AND I HATE NIGGERS");
		AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

		launcherKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.toomanybinds.launcher",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_H,
				"category.toomanybinds"));
		favoriteKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.toomanybinds.favorite",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_F4,
				"category.toomanybinds"));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (launcherKey.wasPressed()) openNewLauncherScreen(client);
		});

		ClientLifecycleEvents.CLIENT_STARTED.register(t -> LauncherCompletion.loadData());
		ClientLifecycleEvents.CLIENT_STOPPING.register(t -> LauncherCompletion.saveData());

		LauncherCompletion.suggestionProviders.add(newVanillaKeyBindSuggestions());
	}

	protected abstract void openNewLauncherScreen(MinecraftClient client);
	protected abstract VanillaKeybindSuggestions newVanillaKeyBindSuggestions();
}
