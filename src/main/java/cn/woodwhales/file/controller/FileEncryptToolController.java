package cn.woodwhales.file.controller;

import cn.woodwhales.file.config.InfoConfig;
import cn.woodwhales.file.service.FileEncryptToolService;
import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author woodwhales on 2021-10-06 23:15
 */
@FXMLController
public class FileEncryptToolController implements Initializable {

    @FXML
    private Label tips;

    @FXML
    private Label productInfo;

    @FXML
    private Label versionInfo;

    @Autowired
    private FileEncryptToolService fileEncryptToolService;

    @Autowired
    private InfoConfig infoConfig;

    private void init() {
        this.productInfo.setText(infoConfig.getProduct());
        this.versionInfo.setText(infoConfig.getVersion());
    }

    @FXML
    public void decode(final Event event) {
        resetTips();
        List<File> files = selectFile("请选择解密文件",
                                      new ExtensionFilter("图片类型","*.png", "*.PNG"));
        if(CollectionUtils.isEmpty(files)) {
            resetTips();
        } else {
            String msg = checkProcess(fileEncryptToolService.decode(files), "解密");
            this.tips.setText(msg);
        }
    }

    @FXML
    public void encode(final Event event) {
        resetTips();
        List<File> files = selectFile("请选择加密文件");
        if(CollectionUtils.isEmpty(files)) {
            resetTips();
        } else {
            String msg = checkProcess(fileEncryptToolService.encode(files), "加密");
            this.tips.setText(msg);
        }
    }

    private void resetTips() {
        this.tips.setText("");
    }

    private String checkProcess(boolean isSuccess, String msg) {
        if(isSuccess) {
            return String.format("%s操作成功", msg);
        } else {
            return String.format("%s操作失败", msg);
        }
    }

    public List<File> selectFile(String fileChooserTitle,
                                 ExtensionFilter... excelFilter) {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();

        ObservableList<ExtensionFilter> extensionFilters = fileChooser.getExtensionFilters();
        extensionFilters.addAll(excelFilter);
        extensionFilters.add(new ExtensionFilter("所有类型","*.*"));

        fileChooser.setTitle(fileChooserTitle);
        List<File> files = fileChooser.showOpenMultipleDialog(stage);
        if(CollectionUtils.isEmpty(files)) {
            return Collections.emptyList();
        }
        return files;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }
}
