package md.faiks.toomanybinds;

import com.github.reviversmc.toomanybinds.LauncherScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;

public class LauncherScreen1204 extends LauncherScreen {

	private boolean repeatEvents;
	@Override
	protected void closeScreen() {
		client.close();
	}


	@Override
	protected void setRepeatKeyboardEvents(boolean repeatEvents) {
		this.repeatEvents = repeatEvents;
	}

	@Override
	protected void addTextField(TextFieldWidget textField) {
		addSelectableChild(textField);
	}
}
