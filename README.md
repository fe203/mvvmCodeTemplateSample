# mvvmCodeTemplateSample
使用AndroidViewModel实现的MVPVM的代码模板，其中P部分省略

### MACOS下，将MVPVMActivity的文件COPY到目录/Applications/Android Studio.app/Contents/plugins/android/lib/templates/activities/即可，Windows请自行寻找相应目录。

在app的示例代码中增加有ViewModelStoreFactory类，可用于多个Activity之间共享数据，其中viewModelStore采用类似于引用计数的方式进行自管理，使用时分两步进行：
### 1、让需要共享的Activity implements ViewModelStoreOwner

### 2、在其getViewModelStore接口中实现
### return ViewModelStoreFactory.getFactory(getApplication()).getViewModelStore(this, YourViewModel.class);
