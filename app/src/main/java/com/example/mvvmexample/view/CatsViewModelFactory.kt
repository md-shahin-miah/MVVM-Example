
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmexample.data.repository.CatsRepository
import com.example.mvvmexample.view.CatsViewModel

//@Suppress("UNCHECKED_CAST")
//class QuotesViewModelFactory(
//    private val repository: QuotesRepository
//) : ViewModelProvider.NewInstanceFactory() {
//
//     fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return QuotesViewModel(repository) as T
//    }
//}

@Suppress("UNCHECKED_CAST")
class CatsViewModelFactory(
    private val repository: CatsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CatsViewModel(repository) as T
    }
}