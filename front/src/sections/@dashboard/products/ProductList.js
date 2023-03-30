import { useEffect, useState } from 'react';


import PropTypes from 'prop-types';
// @mui
import { Grid } from '@mui/material';
import ShopProductCard from './ProductCard';

// ----------------------------------------------------------------------

ProductList.propTypes = {
  products: PropTypes.array.isRequired,
};

export default function ProductList({ products, ...other }) {
  const [voitures, setVoitures] = useState(null);
  useEffect(() => {


    fetch('http://localhost:9090/voiture/list', {
      method: 'GET',
      mode: 'cors',
      headers: {
        'Content-Type': 'application/json',
      }
    })
      .then((data) => { setVoitures(data); console.info(data) })
      .catch(error => console.error(error));

  }, [])
  return (
    <Grid container spacing={3} {...other}>
      {products.map((product) => (
        <Grid key={product.id} item xs={12} sm={6} md={3}>
          <ShopProductCard product={product} />
        </Grid>
      ))}
    </Grid>
  );
}
