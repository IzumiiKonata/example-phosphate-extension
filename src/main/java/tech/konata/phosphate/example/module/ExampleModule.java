package tech.konata.phosphate.example.module;

import org.lwjgl.opengl.GL11;
import tech.konata.phosphate.api.Extension;
import tech.konata.phosphate.api.PApi;
import tech.konata.phosphate.api.enums.EnumCategory;
import tech.konata.phosphate.api.features.ExtensionModule;
import tech.konata.phosphate.api.interfaces.rendering.FontManager;
import tech.konata.phosphate.api.interfaces.settings.BooleanSetting;
import tech.konata.phosphate.api.interfaces.settings.EnumSetting;
import tech.konata.phosphate.api.interfaces.settings.ModeSetting;
import tech.konata.phosphate.api.interfaces.settings.NumberSetting;

/**
 * @author IzumiiKonata
 * Date: 2025/1/27 21:27
 */
public class ExampleModule extends ExtensionModule {

    BooleanSetting bool = Extension.getAPI().createBooleanSetting("Boolean Setting", true);
    NumberSetting<Double> number = Extension.getAPI().createNumberSetting("Number Setting", 1.0, 0.0, 2.0, 0.1);

    EnumSetting<SomeMode> enumSetting = Extension.getAPI().createEnumSetting("Enum Setting", SomeMode.Mode1);
    ModeSetting stringModeSetting = Extension.getAPI().createModeSetting("String Setting", "1", "1", "2", "3");

    public ExampleModule() {
        super("Example Module", "Test Module.", EnumCategory.OTHER);
        super.addSettings(this.bool, this.number, this.enumSetting, this.stringModeSetting);
    }

    @Override
    public void onRender2DEvent() {
        PApi api = Extension.getAPI();

        FontManager fm = api.getFontManager();

        fm.getPf100().drawString("Hello, World!", 100, 100, -1);

        // 你可以使用GL函数!
        api.getGlStateManager().disableTexture2D();
        GL11.glColor4f(1f, 1f, 1f, 1f);
        GL11.glBegin(GL11.GL_QUADS);

        GL11.glVertex2d(0, 0);
        GL11.glVertex2d(0, 100);
        GL11.glVertex2d(100, 100);
        GL11.glVertex2d(100, 0);

        GL11.glEnd();
    }

    public enum SomeMode {
        Mode1,
        Mode2,
        Mode3
    }

}
