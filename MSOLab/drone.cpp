#include<bits/stdc++.h>
using namespace std;

#define N 30
#define POP_SIZE 10
#define numTruck 3
#define numDrone 3
#define numCustomer 21

//vTruck, vDrone, x, y: km/h, releaseDate: minute
int drone_duration = 150;
double vTruck = 45.0;
double vDrone = 30.0;
int droneCapacity = 3; 
int x[N], y[N], releaseDate[N];
double distance_[N][N];
int dim = numCustomer + numTruck - 1;

struct Route {
    int point;
    double percent;
};

class Individual {
public:
    int dim;    
    Route path[N];
    vector<Route> truck1;
    vector<Route> truck2;
    vector<Route> truck3;

    // vector<vector<int>> package_truck1(dim);
    // vector<vector<int>> package_truck2(dim);
    // vector<vector<int>> package_truck3(dim);

    queue<int> package;
    
    double total_time = 0.0;


    Individual() {
        this->dim = dim;
    }

    Individual(const Individual &p) {
        this->dim = p.dim;
        for (int i=0; i<dim; i++) {
            this->path[i].point = p.path[i].point;
            this->path[i].percent = p.path[i].percent;
        }
    }
    
    void randomInit() {
        // init route
        vector<int> v(this->dim);
        for (int i=0; i<this->dim; i++) 
            v[i] = i+1;
        for (int i=0; i<this->dim; i++)
        {
            int index = rand() % this->dim;
            swap(v[i], v[index]);
        }
        for (int i=0; i<this->dim; i++) 
        {
            this->path[i].point=v[i];
        }
        //init percent
        int count = 0;
        while (count < this->dim) {
            double temp = 0;
            while (temp == 0) temp = round(100.0 * rand() / RAND_MAX) / 100.0;
            this->path[count].percent = temp;
            count++;
        }

        // checking 
        for (int i=0; i<this->dim; i++) {
            cout << path[i].point << "\t" << path[i].percent << "\n";
        }
    }

    void truck_routing() {
        int index = 0;
        int count = 0;
        while (index < this->dim) {
            if (count==0 && this->path[index].point <= numCustomer) {
                this->truck1.push_back(path[index]);
                index++;
                if (this->path[index].point > numCustomer) {
                    count++; index++;
                }
            }
            if (count==1 && this->path[index].point <= numCustomer) {
                this->truck2.push_back(path[index]);
                index++;
                if (this->path[index].point > numCustomer) {
                    count++; index++;
                }
            }
            if (count==2 && this->path[index].point <= numCustomer) {
                this->truck3.push_back(path[index]);
                index++;
                if (this->path[index].point > numCustomer) {
                    count++; index++;
                }
            }
        }
    }

    void package_deliver() {
        // truck 1
        for (int i=0; i<this->truck1.size(); i++) {
            double value = this->truck1[i].percent;
            for (int j=0; j<=i; j++) {
                if (value > (double) j / (i + 1) && value <= (double) (j + 1) / (i + 1)) {
                    this->package_truck1[j].push_back(this->truck1[i].point);
                }
            }
        }
        // truck 2
        for (int i=0; i<this->truck2.size(); i++) {
            double value = this->truck2[i].percent;
            for (int j=0; j<=i; j++) {
                if (value > (double) j / (i + 1) && value <= (double) (j + 1) / (i + 1)) {
                    this->package_truck2[j].push_back(this->truck2[i].point);
                }
            }
        }
        // truck 3
        for (int i=0; i<this->truck3.size(); i++) {
            double value = this->truck3[i].percent;
            for (int j=0; j<=i; j++) {
                if (value > (double) j / (i + 1) && value <= (double) (j + 1) / (i + 1)) {
                    this->package_truck3[j].push_back(this->truck3[i].point);
                }
            }
        }
        // package queue
        // vector<vector<int>> total_package(this->dim);
        // int index=0;
        // for (int i=0; i<this->dim; i++) {
        //     if (!package_truck1[i].empty()) {
        //         total_package[index].push_back(package_truck1[i]);    
        //         index++;
        //     }
        // }
        // index = 0;
        // for (int i=0; i<this->dim; i++) {
        //     if (!package_truck2[i].empty()) {
        //         total_package[index].push_back(package_truck2[i]);    
        //         index++;
        //     }
        // }
        // index = 0;
        // for (int i=0; i<this->dim; i++) {
        //     if (!package_truck3[i].empty()) {
        //         total_package[index].push_back(package_truck3[i]);    
        //         index++;
        //     }
        // }
        // for (int i=0; i<this->dim; i++) {
        //     if (!total_package[i].empty()) {
        //         for (int j=0; j<total_package[i].size(); j++) {
        //             package.push(j);
        //         }
        //     }
        // }
    }

    double evaluate() {
        



    }

    
};




void Input() {
    for (int i=1; i<=numCustomer; i++) {
        cin >> x[i] >> y[i] >> releaseDate[i];
    }
    for (int i=1; i<=numCustomer; i++)  {
        for (int j=1; j<=numCustomer; j++) {
            if (i==j) {
                distance_[i][j] = 0.0;
            } else {
                double temp = sqrt(pow(x[i]-x[j], 2) + pow(y[i]-y[j], 2));
                distance_[i][j] = temp;
            }
        }
    }
}

int main() {
    srand( time(NULL) );
    //Input();    
    Individual p; 
    p.randomInit();
    


}


