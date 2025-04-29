import React from 'react';
import logo from './logo.svg';
import './App.css';

import Login from "./components/login/Login"


function App() {
  return (
    <>
      <ThemeProvider theme={theme}>
        <authContext.Provider value={{ role, setRole }}>
          <BrowserRouter>
            <Nav />

            <Routes>
              <Route path="/" element={<HotelPage />} />
              <Route path="/hotelFav" element={<HotelFavorite />} />
              <Route path="/registerHotel" element={<RegisterHotel />} />
              <Route path="/ownerHotels" element={<OwnerHotel />} />
              <Route path="hotels/update/:hotelId" element={<UpdateHotel />} />
              <Route path="/hotels/delete/:hotelId" element={<DeleteHotel />} />

              <Route path="bookings" element={<BookingPage />} />
              <Route path="bookings/reserve" element={<BookingRoom />} />
              <Route path="login" element={<Login />} />
              <Route path="register" element={<Register />} />

            </Routes>
          </BrowserRouter>
        </authContext.Provider>
      </ThemeProvider>
    </>
  );
}

export default App;
