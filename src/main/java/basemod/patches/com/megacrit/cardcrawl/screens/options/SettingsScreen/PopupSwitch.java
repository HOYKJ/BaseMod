package basemod.patches.com.megacrit.cardcrawl.screens.options.SettingsScreen;

import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.screens.options.SettingsScreen;
import com.megacrit.cardcrawl.screens.saveAndContinue.SaveAndContinue;

@SpirePatch(cls="com.megacrit.cardcrawl.screens.options.SettingsScreen", method="popup")
public class PopupSwitch {
	@SpireInsertPatch(rloc=35)
	public static void Insert(Object __obj_instance, Object typeObj) {
		SettingsScreen screen = (SettingsScreen) __obj_instance;
		AbstractPlayer.PlayerClass selection = AbstractDungeon.player.chosenClass;
		if (!selection.toString().equals("IRONCLAD") && !selection.toString().equals("THE_SILENT") &&
				!selection.toString().equals("CROWBOT")) {
			if (!Gdx.files.local(SaveAndContinue.save_path + selection.name() + ".autosave").exists()) {
				screen.exitPopup.desc = SettingsScreen.TEXT[3];
			}
		}
	}
}
