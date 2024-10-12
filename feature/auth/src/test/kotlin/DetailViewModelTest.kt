
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.medicare.auth.detailscreen.DetailViewModel
import com.medicare.data.repository.MedicineRepository
import com.medicare.database.model.Medicine
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class DetailViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val medicineRepository: MedicineRepository = mockk()
    private lateinit var viewModel: DetailViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        viewModel = DetailViewModel(medicineRepository)
    }

    @After
    fun tearDown() {

        Dispatchers.resetMain()
    }

    @Test
    fun `loadMedicine should fetch data correctly`() = runBlockingTest {

        val medicineId=1
        val expectedMedicine = Medicine( id = medicineId,
            name = "Asprin", dose= "500mg", strength = "High")
        coEvery { medicineRepository.getMedicineById(medicineId) } returns expectedMedicine

        viewModel.loadMedicine(medicineId)

        assertEquals(expectedMedicine, viewModel.medicine.value)
        coVerify { medicineRepository.getMedicineById(medicineId) }

    }

    @Test
    fun `loadMedicine should handle null data`(): Unit = runBlockingTest {

        val medicineId = 2
        coEvery { medicineRepository.getMedicineById(medicineId) } returns null


        viewModel.loadMedicine(medicineId)

        assertEquals(null, viewModel.medicine.value)
        coVerify { medicineRepository.getMedicineById(medicineId) }
    }
}