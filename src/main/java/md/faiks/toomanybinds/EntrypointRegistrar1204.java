package md.faiks.toomanybinds;

import com.github.reviversmc.toomanybinds.EntrypointLauncher;
import com.github.reviversmc.toomanybinds.EntrypointRegistrarBase;

public class EntrypointRegistrar1204 extends EntrypointRegistrarBase {
	@Override
	public void onInitialize() {
		if (isCompatible("1.20.4", INFINITE)) {
			EntrypointLauncher.setVersionSpecificInitializer(new TooManyBinds1204());
		}
	}
}
