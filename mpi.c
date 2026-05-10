#include <stdio.h>
#include <mpi.h>

int main(int argc, char *argv[])
{
    int rank, size;
    int N = 20;

    // Array written manually
    int num[20] = {
        1, 2, 3, 4, 5,
        6, 7, 8, 9, 10,
        11, 12, 13, 14, 15,
        16, 17, 18, 19, 20
    };

    int recv[20];
    int local_sum = 0;
    int total_sum = 0;

    MPI_Init(&argc, &argv);

    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    int chunk = N / size;

    // Distribute array elements
    MPI_Scatter(num, chunk, MPI_INT,
                recv, chunk, MPI_INT,
                0, MPI_COMM_WORLD);

    // Calculate local sum
    for (int i = 0; i < chunk; i++)
    {
        local_sum += recv[i];
    }

    printf("Local sum at rank %d = %d\n", rank, local_sum);

    // Add all local sums
    MPI_Reduce(&local_sum, &total_sum,
               1, MPI_INT, MPI_SUM,
               0, MPI_COMM_WORLD);

    // Print final sum
    if (rank == 0)
    {
        printf("Final sum = %d\n", total_sum);
    }

    MPI_Finalize();

    return 0;
}
